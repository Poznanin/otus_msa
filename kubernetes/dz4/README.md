https://istio-io.translate.goog/latest/docs/setup/install/helm/?_x_tr_sl=en&_x_tr_tl=ru&_x_tr_hl=ru&_x_tr_pto=sc

Uninstall
You can uninstall Istio and its components by uninstalling the charts installed above.

List all the Istio charts installed in istio-system namespace:

$ helm ls -n istio-system
NAME       NAMESPACE    REVISION UPDATED         STATUS   CHART        APP VERSION
istio-base istio-system 1        ... ... ... ... deployed base-1.0.0   1.0.0
istiod     istio-system 1        ... ... ... ... deployed istiod-1.0.0 1.0.0

(Optional) Delete any Istio gateway chart installations:

$ helm delete istio-ingress -n istio-ingress
$ kubectl delete namespace istio-ingress

Delete Istio discovery chart:

$ helm delete istiod -n istio-system

Delete Istio base chart:

By design, deleting a chart via Helm doesn’t delete the installed Custom Resource Definitions (CRDs) installed via the chart.
$ helm delete istio-base -n istio-system

Delete the istio-system namespace:

$ kubectl delete namespace istio-system

Для установки егеря нужен cert-manager
https://cert-manager.io/docs/installation/helm/

helm install cert-manager jetstack/cert-manager --namespace cert-manager --create-namespace --version v1.10.0 \
# --set installCRDs=true



helm install -n jaeger-operator -f jaeger/operator-values.yaml jaeger-operator jaegertracing/jaeger-operator
helm install -n jaeger-operator -f jaeger/operator-values.yaml jaeger-operator jaegertracing/jaeger-operator

helm install jaegertracing/jaeger-operator --name jaeger-operator -n jaeger-operator --set rbac.clusterRole=true



Создание токена
D:\repo\otus\kubernetes\dz4>kubectl create token kiali-operator -n kiali-operator
eyJhbGciOiJSUzI1NiIsImtpZCI6IjVjRERGZXB2eUVka3RnTWZTRTBEdTRYNFZORDdEVlFjNTMxMGZTQ2xOakkifQ.eyJhdWQiOlsiaHR0cHM6Ly9rdWJlcm5ldGVzLmRlZmF1bHQuc3ZjLmNsdXN0ZXIubG9jYWwiXSwiZXhwIjoxNjY2MjgzMzkxLCJpYXQiOjE2NjYyNzk3OTEsImlzcyI6Imh0dHBzOi8va3ViZXJuZXRlcy5kZWZhdWx0LnN2Yy5jbHVzdGVyLmxvY2FsIiwia3ViZXJuZXRlcy5pbyI6eyJuYW1lc3BhY2UiOiJraWFsaS1vcGVyYXRvciIsInNlcnZpY2VhY2NvdW50Ijp7Im5hbWUiOiJraWFsaS1vcGVyYXRvciIsInVpZCI6IjAwNzg2MDQ1LTE0ZGQtNDJkMS05NDBiLTQ1OWEwMjM0YjhkYiJ9fSwibmJmIjoxNjY2Mjc5NzkxLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a2lhbGktb3BlcmF0b3I6a2lhbGktb3BlcmF0b3IifQ.L8d1cdkn1eyiT8EcULI1TIX8tCDsjaIIynOHdtXuk5BoyllxdPYhK10noQQjdQPKu1aUjChH6ctBhxAaQxdKmtf5kqMmO4Kol39zKPWHnpignf71ozbvPQesG-eea3pFF1P-ITAhvRMadnyfGsIlGvaECyfjk2MsnLHWXxTLRATyn7f6VqPepNioO6Z9LooxinPKAvioc_brYQAaITSvYmPElwS3W5TmKgD06aNbXeM6HiuSNkFwhZkXEklwvyRG9T6b9v1NBsVekitfSTaYoOxkUSskEzPtuzTf2NitzGXEccoSHl_lBwBa1Zl_zkrZhJUsx_tRej9hjRn94Cl2CQ