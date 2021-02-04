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
      <div className="card  mb-3">
        <div className="card-header">
          LIABILITIES
          <span className="float-right text-success h6">
            {NUMBER_UTILS.convertNumToMoney(total, currency)}
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
