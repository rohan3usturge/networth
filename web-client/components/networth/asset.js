import { Amount } from "./amount";

const Asset = ({ asset, onChange, disabled, currency }) => {
  const handleChange = (changedAmount) => {
    const changed = { ...asset };
    changed.lineItem.amount = changedAmount;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr>
      <td>{asset.lineItem.name}</td>
      <td>
        <div className="input-group mb-3">
          <Amount
            disabled={disabled}
            defaultValue={asset.lineItem.amount}
            currency={currency}
            className="form-control"
            onChange={handleChange}
          />
        </div>
      </td>
    </tr>
  );
};

export { Asset };
