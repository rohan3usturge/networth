import { useEffect, useState } from "react";
import { NUMBER_UTILS } from "../utils";

const Amount = ({ defaultValue, currency, disabled, onChange }) => {
  const initialValue = NUMBER_UTILS.convertNumToMoney(defaultValue, currency);
  const [value, setValue] = useState(initialValue);

  useEffect(() => {
    setValue(NUMBER_UTILS.convertNumToMoney(defaultValue, currency));
  }, [defaultValue, currency]);

  const handleBlur = (e) => {
    const currVal = e.target.value;
    const newVal = NUMBER_UTILS.convertNumToMoney(currVal, currency);
    setValue(newVal);
    if (currVal != defaultValue && onChange) {
      onChange(currVal);
    }
  };

  const handleFocus = (e) => {
    let currVal = e.target.value;
    let newVal = currVal ? NUMBER_UTILS.convertStrToNum(currVal) : "";
    setValue(newVal);
  };

  const handleChange = (e) => {
    let currVal = e.target.value;
    setValue(currVal);
  };

  return (
    <input
      disabled={disabled}
      type="text"
      value={value}
      className="form-control"
      onChange={handleChange}
      onBlur={handleBlur}
      onFocus={handleFocus}
    />
  );
};

export { Amount };
