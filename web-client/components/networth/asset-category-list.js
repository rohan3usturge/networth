import { NUMBER_UTILS } from "../utils";
import { AssetCategory } from "./asset-category";

const AssetCategoryList = ({
  categories,
  onChange,
  disabled,
  total,
  currency,
}) => {
  const handleChange = (changedCategory) => {
    const changed = categories.map((category) => {
      if (category.meta.id == changedCategory.meta.id) {
        return changedCategory;
      }
      return category;
    });
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <>
      <div className="card mb-3">
        <div className="card-header text-white bg-success">
          <h4 class="card-title">
            {NUMBER_UTILS.convertNumToMoney(total, currency)}
          </h4>
          <span className="card-text">
            <i className="fas fa-piggy-bank mr-2"></i>
            ASSETS
          </span>
        </div>
        <div className="card-body">
          {categories.map((category) => {
            return (
              <AssetCategory
                currency={currency}
                key={category.meta.id}
                category={category}
                onChange={handleChange}
                disabled={disabled}
              />
            );
          })}
        </div>
      </div>
    </>
  );
};

export { AssetCategoryList };
