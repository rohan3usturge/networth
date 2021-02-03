const Liability = ({ liability, onChange }) => {
  const handleChange = (e) => {
    const changed = { ...liability };
    changed.amount = e.target.value;
    if (onChange) {
      onChange(changed);
    }
  };

  return (
    <li className="list-group-item">
      <div className="form-group row">
        <label className="col-md-2" htmlFor="liability-amount-input ">
          {liability.lineItem.name}
        </label>
        <span className="col-md-2">{liability.monthlyPayment}</span>
        <input
          type="number"
          value={liability.lineItem.amount}
          className="form-control col-md-8"
          onChange={handleChange}
          id="liability-amount-input"
        />
      </div>
    </li>
  );
};

export { Liability };
