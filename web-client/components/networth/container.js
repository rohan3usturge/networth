import { CurrencyForm } from "./../currency/currency-form";
import { AssetCategoryList } from "./asset-category-list";
import { LiabilityCategoryList } from "./liability-category-list";
import { useState } from "react";
import { NETWORTH_API } from "../../apis/networth_api";
import { NUMBER_UTILS } from "../utils";

const NetWorthContainer = ({ defaultPortfolio, currencies }) => {
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
        <div className="d-flex justify-content-center">
          <div className="spinner-grow text-primary" role="status">
            <span className="sr-only">Loading...</span>
          </div>
        </div>
      )}

      <CurrencyForm
        selectedCurrency={portfolio.currencyCode}
        currencies={currencies}
        onChange={handleCurrencyChange}
      />
      <div className="card text-white bg-primary mb-3">
        <div className="card-body d-flex justify-content-between">
          <span>TOTAL NET WORTH</span>
          {portfolio.netWorth && (
            <span className="h4">
              {NUMBER_UTILS.convertNumToMoney(
                portfolio.netWorth.totalNetWorth,
                portfolio.currencyCode
              )}
            </span>
          )}
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
