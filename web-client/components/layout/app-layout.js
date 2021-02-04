import React from "react";
import { Header } from "./header";
import { Footer } from "./footer";

const withAppLayout = (ComposedComponent) => (props) => (
  <section className="bg-light">
    <Header {...props} />
    <div className="mt-5" />
    <main className="container-md pl-1 pr-1">
      <div>
        <ComposedComponent {...props} />
      </div>
    </main>
    <Footer />
  </section>
);

export default withAppLayout;
