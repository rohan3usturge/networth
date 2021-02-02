import { LineItem } from "./line-item";

const LineItemCategory = ({ category, onUpdate }) => {
  const handleLineItemChange = (updatedItem) => {
    const copy = { ...category };
    const newItems = category.items.map((item) => {
      if (item.id === updatedItem.id) {
        return updatedItem;
      }
      return item;
    });
    copy.items = newItems;
    if (onUpdate) {
      onUpdate(copy);
    }
  };

  return (
    <div className="card bg-light mb-3">
      <div className="card-header">{category.name}</div>
      <ul className="list-group">
        {category.items.map((item) => {
          return (
            <LineItem
              key={item.id}
              item={item}
              onUpdate={handleLineItemChange}
            />
          );
        })}
      </ul>
    </div>
  );
};

export { LineItemCategory };
