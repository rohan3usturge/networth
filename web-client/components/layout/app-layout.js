import React from "react";
import { Header } from "./header";
import { Footer } from "./footer";

const withAppLayout = (ComposedComponent) => (props) => (
  <section>
    <Header {...props} />
    <div className="mt-5" />
    <main className="container-fluid pl-5 pr-5">
      <div>
        <ComposedComponent {...props} />
      </div>
    </main>
    <Footer />
  </section>
);

export default withAppLayout;
