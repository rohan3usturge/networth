import { Liability } from "./liability";

const LiablityCategory = ({ category, onChange }) => {
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
          <th scope="col" className="col-2">
            {category.meta.name}
          </th>
          <th className="col-2">Monthly Payment</th>
          <th className="col-8"></th>
        </tr>
      </thead>
      <tbody>
        {category.items.map((item) => {
          return (
            <Liability
              key={item.lineItem.id}
              liability={item}
              onChange={handleChange}
            />
          );
        })}
      </tbody>
    </table>
  );
};

export { LiablityCategory };
