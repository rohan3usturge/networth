import { LineItemCategory } from "./line-item-category";
import { useState } from "react";

const NetWorthContainer = ({ defaultNetworth }) => {
  const [netWorth, setNetWorth] = useState(defaultNetworth || {});

  const handleCategoryUpdate = (updatedCategory) => {
    const copy = { ...netWorth };
    const newCategories = netWorth.categories.map((category) => {
      if (category.name === updatedCategory.name) {
        return updatedCategory;
      }

      return category;
    });
    copy.categories = newCategories;
    setNetWorth(copy);
  };

  return (
    <div className="card bg-light mb-3">
      <div className="card-header">Net Worth Calculator</div>
      <div className="card-body ">
        <>
          {netWorth.categories.map((category) => {
            return (
              <LineItemCategory
                key={category.name}
                category={category}
                onUpdate={handleCategoryUpdate}
              />
            );
          })}
        </>
        <span>{JSON.stringify(netWorth)}</span>
      </div>
    </div>
  );
};

export { NetWorthContainer };
