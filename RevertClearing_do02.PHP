<?php
$url = "https://appload.scopevisio.com/api/soap/accounting/RevertClearing.do";
$customer = "1000001";
$user = "test_user@scopevisio.com";
$pass = "test_password";
$organisation = "Scopevisio Demo AG";

$authentication = "";
$authentication .= "?" . "customer=" . urlencode($customer);
$authentication .= "&" . "user=" . urlencode($user);
$authentication .= "&" . "pass=" . urlencode($pass);
$authentication .= "&" . "language=" . urlencode("de_DE");
$authentication .= "&" . "organisation=" . urlencode($organisation);

$arguments = "";
$arguments .= "&" . "account=" . urlencode("10008");

// request
$url = $url . $authentication . $arguments;
echo "<b style=\"font-size:small\">Request</b>";
echo "<pre>" . $url . "</pre>";

try {
$curl = curl_init($url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($curl);
$result = curl_errno($curl);
// response
echo "<br /><b style=\"font-size:small\">Response</b>";
if ($result) {
echo "<pre>" . $result . ": " . curl_error($curl) . "</pre>";
} else {
echo "<pre>" . print_r(htmlentities($response), true) . "</pre>";
}
curl_close($curl);
} catch (Exception $exception) {
echo "Exception: " . $exception;
exit;
}
?>
