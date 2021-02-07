import { useEffect, useState } from "react";
import { NUMBER_UTILS } from "../utils";
import { useRouter } from "next/router";

const Amount = ({ defaultValue, currency, disabled, onChange }) => {
  const router = useRouter();
  const locale = router.locale;
  const initialValue = NUMBER_UTILS.convertNumToMoney(
    defaultValue,
    currency,
    locale
  );
  const [value, setValue] = useState(initialValue);
  const [isError, setIsError] = useState(false);

  useEffect(() => {
    setValue(NUMBER_UTILS.convertNumToMoney(defaultValue, currency, locale));
  }, [defaultValue, currency]);

  const handleBlur = (e) => {
    const currVal = e.target.value;
    const newVal = NUMBER_UTILS.convertNumToMoney(currVal, currency, locale);
    setValue(newVal);
    if (!isError && currVal != defaultValue && onChange) {
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
    if (!currVal || !currVal.length) {
      currVal = "0.0";
    }
    currVal = currVal.replace(/[^0-9.]+/g, "");
    if (isNaN(currVal)) {
      setIsError(true);
    } else {
      setIsError(false);
    }
    setValue(currVal);
  };

  return (
    <div className="flex-column">
      <input
        disabled={disabled}
        type="text"
        value={value}
        className="form-control money-input"
        onChange={handleChange}
        onBlur={handleBlur}
        onFocus={handleFocus}
      />
      {isError && (
        <div className="text-danger">
          <i className="fas fa-exclamation mr-1"></i>
          <small>Please enter a valid number</small>
        </div>
      )}
    </div>
  );
};

export { Amount };
