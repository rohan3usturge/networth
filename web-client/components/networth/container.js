import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";
import { NETWORTH_API } from "../../apis/networth_api";

const NetWorthContainer = ({ defaultPortfolio }) => {
  const [portfolio, setPortfolio] = useState(defaultPortfolio || {});
  const [isLoading, setIsLoading] = useState(false);

  function timeout(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

  const fetchNetWorth = async (portfolioRequest) => {
    setIsLoading(true);
    const nw = await NETWORTH_API.getNetWorth({
      portfolio: {
        lineItems: portfolioRequest.lineItems,
        currencyCode: portfolioRequest.currencyCode,
      },
      targetCurrencyCode: portfolioRequest.targetCurrencyCode,
    });
    await timeout(1500);
    setIsLoading(false);
    setPortfolio({
      currencyCode: nw.portfolio.currencyCode,
      targetCurrencyCode: nw.portfolio.currencyCode,
      lineItems: nw.portfolio.lineItems,
      netWorth: nw.portfolio.netWorth,
    });
  };

  const handleLiabilitiesChange = (changedL) => {
    const changed = { ...portfolio };
    changed.lineItems.liabilities = changedL;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  const handleAssetChange = (changedA) => {
    const changed = { ...portfolio };
    changed.lineItems.assets = changedA;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  const handleCurrencyChange = (changedC) => {
    const changed = { ...portfolio };
    changed.targetCurrencyCode = changedC;
    setPortfolio(changed);
    fetchNetWorth(changed);
  };

  return (
    <>
      {isLoading && (
        <div
          className="spinner-grow text-primary d-flex justify-content-center"
          role="status"
        >
          <span className="sr-only">Loading...</span>
        </div>
      )}
      <CurrencyForm
        selectedCurrency={portfolio.currencyCode}
        currencies={[
          { currencyCode: "CAD" },
          { currencyCode: "USD" },
          { currencyCode: "INR" },
        ]}
        onChange={handleCurrencyChange}
      />
      <AssetCategoryList
        categories={portfolio.lineItems.assets}
        onChange={handleAssetChange}
        disabled={isLoading}
        total={portfolio.netWorth ? portfolio.netWorth.totalAssets : undefined}
      />
      <LiabilityCategoryList
        categories={portfolio.lineItems.liabilities}
        onChange={handleLiabilitiesChange}
        disabled={isLoading}
      />
    </>
  );
};

export { NetWorthContainer };
