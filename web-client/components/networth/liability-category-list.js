import { LiablityCategory } from "./liability-category";
import { NUMBER_UTILS } from "./../utils";
import { useRouter } from "next/router";
import { withTranslation } from "react-i18next";

const Wrapper = ({ categories, onChange, disabled, currency, total, t }) => {
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
          <h4 className="card-title">
            {NUMBER_UTILS.convertNumToMoney(
              total,
              currency,
              useRouter().locale
            )}
          </h4>
          <span className="card-text">
            <i className="fas fa-file-invoice mr-2"></i>
            {t("liabilities")}
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

const LiabilityCategoryList = withTranslation()(Wrapper);

export { LiabilityCategoryList };
