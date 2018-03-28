(ns material-ui-demo.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [material-ui-demo.core-test]))

(doo-tests 'material-ui-demo.core-test)
