import { LiablityCategory } from "./liability-category";

const LiabilityCategoryList = ({ categories, onChange }) => {
  const handleChange = (changedCategory) => {
    const changed = categories.map((category) => {
      if (category.id === changedCategory.id) {
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
        <div className="card-header">categories</div>
        <div className="card-body">
          {categories.map((category) => {
            return (
              <LiablityCategory
                key={category.meta.id}
                category={category}
                onChange={handleChange}
              />
            );
          })}
        </div>
      </div>
    </>
  );
};

export { LiabilityCategoryList };
