import Head from "next/head";
import Link from "next/link";

const DocsLink = process.env.NEXT_PUBLIC_DOCS_URL;

const Header = ({ locale }) => (
  <div>
    <Head>
      <title>Net Worth Calculator</title>
      <link rel="icon" href="/favicon.ico" />
    </Head>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <a className="navbar-brand" href="#">
        <span className="h4">
          NET WORTH <em>calc</em>
        </span>
      </a>
      <button
        className="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
          <li
            className={`nav-item ${
              locale && locale.toLowerCase() == "en-ca" ? "active" : ""
            }`}
          >
            <Link href="/" locale="en-ca">
              <a className="nav-link">English</a>
            </Link>
          </li>
          <li
            className={`nav-item ${
              locale && locale.toLowerCase() == "fr-ca" ? "active" : ""
            }`}
          >
            <Link href="/" locale="fr-ca">
              <a className="nav-link">français</a>
            </Link>
          </li>
          <li className="nav-item">
            <a className="nav-link" target="_blank" href={DocsLink}>
              Docs
            </a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
);

export { Header };
