import { withTranslation } from "react-i18next";
import Select from "react-select";
import { CURRENCY_UTILS } from "./../utils";

const Wrapper = ({ currencies, onChange, selectedCurrency, t }) => {
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
            {t("currency")}
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

const CurrencyForm = withTranslation()(Wrapper);

export { CurrencyForm, Wrapper };
