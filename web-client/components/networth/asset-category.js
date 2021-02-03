import { Asset } from "./asset";

const AssetCategory = ({ category, onChange }) => {
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
    <table className="table table-borderless">
      <thead>
        <tr className="d-flex">
          <th scope="col" className="col-4">
            {category.meta.name}
          </th>
          <th className="col-8"></th>
        </tr>
      </thead>
      <tbody>
        {category.items.map((item) => {
          return (
            <Asset
              key={item.lineItem.id}
              asset={item}
              onChange={handleChange}
            />
          );
        })}
      </tbody>
    </table>
  );
};

export { AssetCategory };
