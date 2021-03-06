
# Architecture Design Record for Frontend

## Objective

To come up with a choice of technology for networth's frontend.

To keep it short, decision is made between react and angular.

But Vue, Svelte, Preact were considered too. Mainly dropped due to maturity, CSR + SSR support and existing ecosystem.

## Decision

React with NextJs as the rendering framework has been chosen.
React due to it's functional programming paradigm, modular architecture, extensive tooling system and great support for SSR. Large community assures continuous performance improvements in SSR, Bundle Size.  


## Comparison





| Category                             | Criteria                                                                      | Angular                                        | React                                 |
|--------------------------------------|-------------------------------------------------------------------------------|------------------------------------------------|---------------------------------------|
| Customer Centric                     | Performance                                                                   | Competitive with Angular Compiler              | Competitive with VIrtual Dom          |
|                                      | Possibility to create any UX                                                  | Possible                                       | Possible                              |
|                                      | Time to Market                                                                | Fast                                           | Fast                                  |
|                                      | Mobile Development                                                            | Integrates With NativeScript                   | React Native                          |
|                                      | CSR vs SSR vs Static Pages                                                    | Angular Universal                              | NextJs                                |
|                                      | Stability                                                                     | Good. Production tested.                       | Good Production tested                |
|                                      | Bundle Sizing                                                                 | Splitable , Tree Shaking, React Lazy, Suspense | Could bloat up depending on libraries |
|                                      |                                                                               |                                                |                                       |
| Developer Centric                    | Paradigm                                                                      | More on Object Oriented Side                   | Functional Programming                |
|                                      | Routing, Animation, DI, Build, CLI                                            | In Built                                       | Pluggable                             |
|                                      | State Management                                                              | Bi Directional                                 | UniDirectional                        |
|                                      | Community and Learning                                                        | Good and Learning curve higher                 | Good. Simpler to start off.           |
|                                      | Sharability to Mobile or other clients                                        | Possible but lock in                           | Possible                              |
|                                      | Backward and Forward Compatibility                                            | Easier due to framework                        | Could be difficult due to ecosystem   |
|                                      |                                                                               |                                                |                                       |
| Organizational and Overall Direction | Intuit using react currently for web development opens more avenues for reuse of resources and components |                                                |                                       |
|                                      | Market and also industry trend is moving towards React more           |                                                |                                       |
|                                      |                                                                               |                                                |                                       |
