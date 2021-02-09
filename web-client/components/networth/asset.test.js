import { shallow } from "enzyme";
import { Amount } from "./amount";
import { Asset } from "./asset";

describe("Liability", () => {
  it("should render properly and match snapshot", () => {
    const wrapper = shallow(
      <Asset
        asset={{ meta: {}, lineItem: {} }}
        currency="CAD"
        disabled={true}
        onChange={() => {}}
      />
    );
    expect(wrapper).toMatchSnapshot();
  });

  it("should call onChage correctly", () => {
    const asset = {
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
      <Asset asset={asset} currency="CAD" disabled={true} onChange={onChange} />
    );

    const props = wrapper.find(Amount).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(30);
    expect(onChange).toHaveBeenCalledTimes(1);
  });

  it("should not call onChage correctly", () => {
    const asset = {
      lineItem: {
        id: 1,
        name: "One",
        amount: 20.0,
      },
    };

    const wrapper = shallow(
      <Asset asset={asset} currency="CAD" disabled={true} />
    );

    const props = wrapper.find(Amount).first().props();
    const changeFunctionCall = props.onChange;
    changeFunctionCall(30);
  });
});
