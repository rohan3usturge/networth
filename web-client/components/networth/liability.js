const Liability = ({ liability, onChange }) => {
  const handleChange = (e) => {
    const changed = { ...liability };
    changed.amount = e.target.value;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <tr className="d-flex">
      <td className="col-2">{liability.lineItem.name}</td>
      <td className="col-2">{liability.monthlyPayment}</td>
      <td className="col-8">
        <input
          type="number"
          value={liability.lineItem.amount}
          className="form-control"
          onChange={handleChange}
          id="liability-amount-input"
        />
      </td>
    </tr>
  );
};

export { Liability };
