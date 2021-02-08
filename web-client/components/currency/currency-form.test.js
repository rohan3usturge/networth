import { shallow } from "enzyme";
import Select from "react-select";
import { Wrapper } from "./currency-form";

/** @test {Title Component} */
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
});
