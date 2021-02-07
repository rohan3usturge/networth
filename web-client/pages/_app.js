import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "../styles/globals.css";
import i18n from "../i18n";

function MyApp({ Component, pageProps }) {
  const { locale } = pageProps;
  i18n(locale);
  return <Component {...pageProps} />;
}

export default MyApp;
