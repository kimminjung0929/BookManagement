<template>
  <div class="d-flex flex-column align-items-center mt-5" style="height: 700px ">
    <h3 class="mb-2">대여 목록</h3>
    <div style="width:80%" >
      <div class="d-flex justify-content-end">
        <input type="text" class="form-control" id="" placeholder="도서명" style="width:180px">
        <select class="form-select mx-3" style="width: 150px">
          <option selected>목록</option>
          <option value="1">전체</option>
          <option value="2">기술과학</option>
          <option value="3">언어</option>
        </select>
        <button type="button" class="btn btn-primary">검색</button>
      </div>
      <br>
      <div class="d-flex justify-content-center">
        <table class="table table-striped" >
          <thead>
            <tr>
              <th class="text-center" scope="col">No.</th>
              <th class="text-center" scope="col">회원명</th>
              <th class="text-center" scope="col">도서명</th>
              <th class="text-center" scope="col">대여상태</th>
              <th class="text-center" scope="col">반납</th>
              <th class="text-center" scope="col">대여 날짜</th>
              <th class="text-center" scope="col">반납 날짜</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="text-center">1</td>
              <td class="text-center">xxx</td>
              <td class="text-center" >xxx</td>
              <td class="text-center" >반납완료</td>
              <td class="text-center">반납완료</td>
              <td class="text-center" >2020-02-02</td>
              <td class="text-center" >2020-02-02</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    setup() {

        
        return {

        }

    }
}
</script>

<style>

</style>