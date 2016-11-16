Based on [Pubby](http://wifo5-03.informatik.uni-mannheim.de/pubby/) 0.3.3.

It supports requesting multi-URI-base (either sub-domain or URL path) data in the same sparql query point.

1. Forward URI Base to pubby (with prefix),
e.g., `http://data.crystalbridges.org/` is forwarded to `http://data.americanartcollaborative.org/cbm/`

2. In `config.ttl`, add mapping rules:
    ```	
    conf:webBase <http://data.americanartcollaborative.org/>
    conf:dataset [
        ...
        conf:multiURIMapping [
            conf:multiURIPrefix "cbm"; # required
            conf:multiURIBase <http://data.crystalbridges.org/>; # required
            conf:multiURIName "Crystal Bridges Museum of American Art";
            conf:multiURIHomepage <http://crystalbridges.org/>;
        ];
    ];
    ```

