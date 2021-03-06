if (${env:COVERAGE_BUILD} -ne 0) {
  $codecov_root_folder = ${env:APPVEYOR_BUILD_FOLDER} -replace "\\", "/"
  $rle_codecov_coverage_file = "${codecov_root_folder}/rle/target/site/jacoco/jacoco.xml"
  $jewellery_and_stones_codecov_coverage_file = "${codecov_root_folder}/jewelery-and-stones/target/site/jacoco/jacoco.xml"
  Write-Host "Sending coverage data to Codecov"
  appveyor-retry codecov --required --token "${env:CODECOV_TOKEN}" --file "${rle_codecov_coverage_file}" "${jewellery_and_stones_codecov_coverage_file}" --root "${codecov_root_folder}" -X gcov;
  if (${LastExitCode} -ne 0) {
    throw "Failed to send coverage data to Codecov"
  }
}
