import { shallow } from "enzyme";
import Select from "react-select";
import { Wrapper } from "./currency-form";

describe("CurrencyForm", () => {
  it("should render properly and match snapshot", () => {
    const translations = {
      currency: "Currency",
    };

    const currencies = ["CAD", "AUS"];
    const wrapper = shallow(
      <Wrapper
        selectedCurrency="CAD"
        currencies={currencies}
        t={(currency) => translations[currency]}
      />
    );
    const label = wrapper.find("label");
    const selectProps = wrapper.find(Select).props();
    expect(selectProps.defaultValue.value).toBe("CAD");
    expect(selectProps.options.length).toBe(currencies.length);
    expect(label).toHaveLength(1);
    expect(label.text()).toBe(translations.currency);
    expect(wrapper).toMatchSnapshot();
  });

  it("should call on change", () => {
    const onChange = jest.fn((changed) => {
      expect(changed).toBe("INR");
    });
    const currencies = ["CAD", "AUS"];
    const wrapper = shallow(
      <Wrapper
        selectedCurrency="CAD"
        currencies={currencies}
        t={(key) => key}
        onChange={onChange}
      />
    );

    wrapper.find(Select).props().onChange({ value: "INR" });
    expect(onChange).toHaveBeenCalledWith("INR");
  });

  it("should not call on change if undefined", () => {
    const currencies = ["CAD", "AUS"];
    const wrapper = shallow(
      <Wrapper
        selectedCurrency="CAD"
        currencies={currencies}
        t={(key) => key}
      />
    );

    wrapper.find(Select).props().onChange({ value: "INR" });
  });
});
