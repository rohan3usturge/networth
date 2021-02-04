import { Asset } from "./asset";

const AssetCategory = ({ category, onChange, disabled, currency }) => {
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
          <th></th>
        </tr>
      </thead>
      <tbody>
        {category.items.map((item) => {
          return (
            <Asset
              currency={currency}
              key={item.lineItem.id}
              asset={item}
              onChange={handleChange}
              disabled={disabled}
            />
          );
        })}
      </tbody>
    </table>
  );
};

export { AssetCategory };
