import { TIME_UTILS } from "./utils";

jest.useFakeTimers();

describe("UTILS", () => {
  it("should timeout be called with correct ms", () => {
    TIME_UTILS.timeout(200);
    expect(setTimeout).toHaveBeenCalledTimes(1);
    expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 200);
  });
});
