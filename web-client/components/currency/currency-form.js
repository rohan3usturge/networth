import Select from "react-select";
import { CURRENCY_UTILS } from "./../utils";

const CurrencyForm = ({ currencies, onChange, selectedCurrency }) => {
  const handleChange = ({ value }) => {
    if (onChange) {
      onChange(value);
    }
  };

  const getClass = (curr) => {
    const props = CURRENCY_UTILS.currencyCodeToFaClass[curr];
    return props ? props.class : "";
  };

  const getLabel = (curr) => {
    const props = CURRENCY_UTILS.currencyCodeToFaClass[curr];
    return props ? props.label : "";
  };

  const options = currencies.map((curr) => ({
    value: curr,
    label: (
      <span id={`option-${curr}`}>
        <i className={`mr-2 fa ${getClass(curr)}`}></i>
        {curr} - {getLabel(curr)}
      </span>
    ),
  }));

  const selectedValue = options.find((o) => o.value === selectedCurrency);

  return (
    <div className="card mb-3">
      <div className="card-body">
        <div className="form-group">
          <label className="h6 mb-2" htmlFor="currency-select">
            CURRENCY
          </label>
          <Select
            id="currency-seletor"
            defaultValue={selectedValue}
            onChange={handleChange}
            options={options}
          />
        </div>
      </div>
    </div>
  );
};

export { CurrencyForm };
