import { shallow } from "enzyme";
import { Liability } from "./liability";
import { Amount } from "./amount";

jest.mock("next/router", () => {
  return {
    useRouter: () => ({ locale: "en-ca" }),
  };
});

describe("Liability", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Liability
        liability={{ meta: {}, lineItem: {} }}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    expect(wrapper).toMatchSnapshot();
  });

  it("should call onChage correctly", () => {
    const liability = {
      lineItem: {
        id: 1,
        name: "One",
        amount: 20.0,
      },
    };
    const onChange = jest.fn((changed) => {
      expect(changed).not.toBeNull();
      expect(changed.lineItem.amount).toBe(30);
    });

    const wrapper = shallow(
      <Liability
        liability={liability}
        currency="CAD"
        disabled={true}
        onChange={onChange}
      />
    );

    const props = wrapper.find(Amount).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(30);
    expect(onChange).toHaveBeenCalledTimes(1);
  });

  it("should not call onChage if not passed", () => {
    const liability = {
      lineItem: {
        id: 1,
        name: "One",
        amount: 20.0,
      },
    };

    const wrapper = shallow(
      <Liability liability={liability} currency="CAD" disabled={true} />
    );

    const props = wrapper.find(Amount).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(30);
  });
});
