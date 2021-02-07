import { NUMBER_UTILS } from "../utils";
import { Amount } from "./amount";
import { useRouter } from "next/router";

const Liability = ({ liability, onChange, disabled, currency }) => {
  const handleChange = (changedAmount) => {
    const changed = { ...liability };
    changed.lineItem.amount = changedAmount;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr>
      <td>{liability.lineItem.name}</td>
      <td>
        {NUMBER_UTILS.convertNumToMoney(
          liability.monthlyPayment,
          currency,
          useRouter().locale
        )}
      </td>
      <td>
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
