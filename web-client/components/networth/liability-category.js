import { withTranslation } from "react-i18next";
import { Liability } from "./liability";

const Wrapper = ({ category, onChange, disabled, currency, t }) => {
  const handleChange = (changedItem) => {
    const changed = { ...category };
    const newItems = category.items.map((item) => {
      if (item.lineItem.id === changedItem.lineItem.id) {
        return changedItem;
      }
      return item;
    });
    changed.items = newItems;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <table className="table table-borderless table-sm">
      <thead>
        <tr>
          <th scope="col">{category.meta.name}</th>
          <th>{t("monthlyPayment")}</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        {category.items.map((item) => {
          return (
            <Liability
              currency={currency}
              key={item.lineItem.id}
              liability={item}
              onChange={handleChange}
              disabled={disabled}
            />
          );
        })}
      </tbody>
    </table>
  );
};

const LiablityCategory = withTranslation()(Wrapper);

export { LiablityCategory };
