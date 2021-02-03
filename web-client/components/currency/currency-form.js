import { useState } from "react";

const CurrencyForm = ({ currencies, onChange, selectedCurrency }) => {
  const [currency, setCurrency] = useState(selectedCurrency);

  const handleChange = (e) => {
    const value = e.target.value;
    setCurrency(value);
    if (onChange) {
      onChange(value);
    }
  };

  return (
    <div className="form-group">
      <label htmlFor="currency-select">Currency</label>
      <select
        id="currency-select"
        value={currency}
        onChange={handleChange}
        className="form-control"
      >
        <option>Choose...</option>
        {currencies ? (
          currencies.map((curr) => (
            <option key={curr.currencyCode} value={curr.currencyCode}>
              {curr.currencyCode}
            </option>
          ))
        ) : (
          <></>
        )}
      </select>
    </div>
  );
};

export { CurrencyForm };
