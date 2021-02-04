import { NETWORTH_API } from "../apis/networth_api";
import withAppLayout from "../components/layout/app-layout";
import { NetWorthContainer } from "../components/networth/container";

const Home = ({ portfolio, currencies }) => {
  return (
    <div>
      <NetWorthContainer currencies={currencies} defaultPortfolio={portfolio} />
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
  const currencyCall = NETWORTH_API.getCurrencies();
  const finalPortfolioCall = NETWORTH_API.getNetWorth(nwRequest);
  const result = await Promise.all([currencyCall, finalPortfolioCall]);
  return {
    props: {
      currencies: result[0],
      portfolio: result[1].portfolio || {},
    },
  };
}
