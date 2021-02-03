const Asset = ({ asset, onChange }) => {
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
        <input
          type="number"
          value={asset.lineItem.amount}
          className="form-control"
          onChange={handleChange}
          id="liability-amount-input"
        />
      </td>
    </tr>
  );
};

export { Asset };
