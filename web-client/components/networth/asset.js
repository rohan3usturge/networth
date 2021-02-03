const Asset = ({ asset, onChange }) => {
  const handleChange = (e) => {
    const changed = { ...asset };
    changed.amount = e.target.value;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <>
      <li className="list-group-item">
        <div className="form-group row">
          <label className="col-md-2" htmlFor="asset-amount-input">
            {asset.lineItem.name}
          </label>
          <input
            type="number"
            value={asset.lineItem.amount}
            className="form-control col-md-8"
            onChange={handleChange}
            id="asset-amount-input"
          />
        </div>
      </li>
    </>
  );
};

export { Asset };
