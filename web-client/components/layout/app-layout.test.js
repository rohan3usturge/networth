import withAppLayout from "./app-layout";
import { shallow } from "enzyme";

describe("AppLayout", () => {
  it("should render properly and match snapshot", () => {
    const Dummy = withAppLayout(() => <span>Hello</span>);
    const wrapper = shallow(<Dummy />);
    expect(wrapper).toMatchSnapshot();
  });
});
