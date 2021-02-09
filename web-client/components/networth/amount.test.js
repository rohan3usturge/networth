import { shallow } from "enzyme";
import { Amount } from "./amount";
import { render, fireEvent, screen } from "@testing-library/react";
import { NUMBER_UTILS } from "../utils";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("Amount", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Amount
        defaultValue="3.00"
        currency="CAD"
        disabled={true}
        onChange={() => {}}
        key="1212"
      />
    );
    expect(wrapper).toMatchSnapshot();
  });

  it("should update input value on focus and blur", () => {
    const value = 3.01;
    const strVal = NUMBER_UTILS.convertNumToMoney(value, "CAD", "en-ca");
    const numVal = NUMBER_UTILS.convertStrToNum(strVal);
    render(
      <Amount
        defaultValue={value}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
        key="1212"
      />
    );
    const input = screen.queryByDisplayValue(strVal);
    expect(input).not.toBeNull();
    fireEvent.focus(input);
    expect(input.value).toBe(numVal.toString());
    fireEvent.blur(input);
    expect(input.value).toBe(strVal);
  });

  it("should update input value on change", () => {
    const value = 3.01;
    const changedValue = 3.02;
    const strVal = NUMBER_UTILS.convertNumToMoney(value, "CAD", "en-ca");
    const changedValStr = NUMBER_UTILS.convertNumToMoney(
      changedValue,
      "CAD",
      "en-ca"
    );
    render(
      <Amount
        defaultValue={value}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    const input = screen.queryByDisplayValue(strVal);
    expect(input).not.toBeNull();
    fireEvent.change(input, {
      target: { value: `${changedValue}` },
    });
    expect(input.value).toBe(changedValue.toString());
    fireEvent.blur(input);
    expect(input.value).toBe(changedValStr);
  });

  it("should show eror when text is not a number", () => {
    const value = 3.01;
    const strVal = NUMBER_UTILS.convertNumToMoney(value, "CAD", "en-ca");
    const AmountComponent = () => (
      <Amount
        defaultValue={value}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    render(<AmountComponent />);
    const input = screen.queryByDisplayValue(strVal);
    expect(input).not.toBeNull();

    // Input not a number
    let changedValue = "adasd";
    fireEvent.change(input, {
      target: { value: `${changedValue}` },
    });
    expect(input.value).toBe("");

    // blank
    fireEvent.change(input, {
      target: { value: "" },
    });

    // Errror Message
    changedValue = "0....";
    fireEvent.change(input, {
      target: { value: `${changedValue}` },
    });
    const error = "Please enter a valid number";
    expect(screen.queryAllByText(error)).toHaveLength(1);
    fireEvent.change(input, {
      target: { value: `${value}` },
    });
    expect(input.value).toBe(value.toString());
    expect(screen.queryAllByAltText(error)).toHaveLength(0);
  });
});
