import { LiablityCategory } from "./liability-category";
import { NUMBER_UTILS } from "./../utils";

const LiabilityCategoryList = ({
  categories,
  onChange,
  disabled,
  currency,
  total,
}) => {
  const handleChange = (changedCategory) => {
    const changed = categories.map((category) => {
      if (category.meta.id === changedCategory.meta.id) {
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
        <div className="card-header bg-danger text-white">
          <h4 class="card-title">
            {NUMBER_UTILS.convertNumToMoney(total, currency)}
          </h4>
          <span className="card-text">
            <i className="fas fa-file-invoice mr-2"></i>
            LIABILITIES
          </span>
        </div>
        <div className="card-body">
          {categories.map((category) => {
            return (
              <LiablityCategory
                key={category.meta.id}
                currency={currency}
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

export { LiabilityCategoryList };
