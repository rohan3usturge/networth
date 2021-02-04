import { NUMBER_UTILS } from "../utils";
import { Amount } from "./amount";

const Liability = ({ liability, onChange, disabled, currency }) => {
  const handleChange = (changedAmount) => {
    const changed = { ...liability };
    changed.lineItem.amount = changedAmount;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr className="d-flex">
      <td className="col-2">{liability.lineItem.name}</td>
      <td className="col-2">
        {NUMBER_UTILS.convertNumToMoney(liability.monthlyPayment, currency)}
      </td>
      <td className="col-8">
        <Amount
          disabled={disabled}
          defaultValue={liability.lineItem.amount}
          currency={currency}
          className="form-control"
          onChange={handleChange}
        />
      </td>
    </tr>
  );
};

export { Liability };
