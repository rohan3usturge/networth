const LineItem = ({ item, onUpdate }) => {
  const handleAmountChange = (e) => {
    const copy = { ...item };
    copy.amount = e.target.value;
    if (onUpdate) {
      onUpdate(copy);
    }
  };

  return (
    <>
      <li className="list-group-item">
        <div className="form-group row">
          <label className="col-md-2" htmlFor="item-amount-input ">
            {item.name}
          </label>
          <span className="col-md-2">{item.description}</span>
          <input
            type="number"
            value={item.amount}
            className="form-control col-md-8"
            onChange={handleAmountChange}
            id="item-amount-input"
          />
        </div>
      </li>
    </>
  );
};

export { LineItem };
