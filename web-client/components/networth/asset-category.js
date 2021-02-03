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
    <div className="mb-3">
      <div className="h6">{category.meta.name}</div>
      <ul className="list-group list-group-flush">
        {category.items.map((item) => {
          return <Asset key={item.id} asset={item} onChange={handleChange} />;
        })}
      </ul>
    </div>
  );
};

export { AssetCategory };
