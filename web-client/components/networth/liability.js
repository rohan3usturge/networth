const Liability = ({ liability, onChange, disabled, currency }) => {
  const handleChange = (e) => {
    const changed = { ...liability };
    changed.lineItem.amount = e.target.value;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr className="d-flex">
      <td className="col-2">{liability.lineItem.name}</td>
      <td className="col-2">{liability.monthlyPayment}</td>
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
