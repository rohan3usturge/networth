const Asset = ({ asset, onChange, disabled }) => {
  const handleChange = (e) => {
    const changed = { ...asset };
    changed.amount = e.target.value;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr className="d-flex">
      <td className="col-4">{asset.lineItem.name}</td>
      <td className="col-8">
        <div className="input-group mb-3">
          <div className="input-group-prepend">
            <span className="input-group-text">$</span>
          </div>
          <input
            disabled={disabled}
            type="text"
            value={asset.lineItem.displayAmount}
            className="form-control"
            onChange={handleChange}
            id="liability-amount-input"
          />
        </div>
      </td>
    </tr>
  );
};

export { Asset };
