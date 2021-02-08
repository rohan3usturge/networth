import { NUMBER_UTILS } from "../utils";
import { AssetCategory } from "./asset-category";
import { useRouter } from "next/router";
import { withTranslation } from "react-i18next";

const Wrapper = ({ categories, onChange, disabled, total, currency, t }) => {
  const locale = useRouter().locale;
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
          <h4 className="card-title">
            {NUMBER_UTILS.convertNumToMoney(total, currency, locale)}
          </h4>
          <span className="card-text">
            <i className="fas fa-piggy-bank mr-2"></i>
            {t("assets")}
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

const AssetCategoryList = withTranslation()(Wrapper);

export { AssetCategoryList, Wrapper };
