import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";
import { NETWORTH_API } from "../../apis/networth_api";
import { NUMBER_UTILS } from "../utils";

const NetWorthContainer = ({ defaultPortfolio }) => {
  const [portfolio, setPortfolio] = useState(defaultPortfolio || {});
  const [isLoading, setIsLoading] = useState(false);

  function timeout(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

  const fetchNetWorth = async (currentPortfolio, targetCurrencyCode) => {
    setIsLoading(true);
    targetCurrencyCode = targetCurrencyCode || currentPortfolio.currencyCode;
    const nwRequest = {
      portfolio: currentPortfolio,
      targetCurrencyCode,
    };
    const nw = await NETWORTH_API.getNetWorth(nwRequest);
    await timeout(1500);
    setIsLoading(false);
    setPortfolio(nw.portfolio);
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
    fetchNetWorth(portfolio, changedC);
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
          { currencyCode: "EUR" },
          { currencyCode: "GBP" },
          { currencyCode: "CHF" },
        ]}
        onChange={handleCurrencyChange}
      />
      <div className="card mb-3">
        <div className="card-body">
          <span>TOTAL NET WORTH</span>
          <span className="float-right text-success h6">
            {NUMBER_UTILS.convertNumToMoney(
              portfolio.netWorth && portfolio.netWorth.totalNetWorth,
              portfolio.currencyCode
            )}
          </span>
        </div>
      </div>
      <AssetCategoryList
        currency={portfolio.currencyCode}
        categories={portfolio.lineItems.assets}
        onChange={handleAssetChange}
        disabled={isLoading}
        total={portfolio.netWorth ? portfolio.netWorth.totalAssets : undefined}
      />
      <LiabilityCategoryList
        currency={portfolio.currencyCode}
        categories={portfolio.lineItems.liabilities}
        onChange={handleLiabilitiesChange}
        disabled={isLoading}
        total={
          portfolio.netWorth ? portfolio.netWorth.totalLiabilities : undefined
        }
      />
    </>
  );
};

export { NetWorthContainer };
