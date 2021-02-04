import { NETWORTH_API } from "../apis/networth_api";
import withAppLayout from "../components/layout/app-layout";
import { NetWorthContainer } from "../components/networth/container";

const Home = ({ portfolio }) => {
  return (
    <div>
      <NetWorthContainer defaultPortfolio={portfolio} />
    </div>
  );
};

export default withAppLayout(Home);

export async function getServerSideProps() {
  const lineItems = await NETWORTH_API.getDefaultLineItems();
  const currencyCode = "CAD";
  const portfolio = {
    currencyCode,
    lineItems,
  };
  const nwRequest = {
    portfolio,
    targetCurrencyCode: currencyCode,
  };
  const finalPortfolio = await NETWORTH_API.getNetWorth(nwRequest);
  return {
    props: {
      portfolio: finalPortfolio.portfolio || {},
    },
  };
}
