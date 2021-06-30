<template>
  <div class="d-flex flex-column align-items-center mt-5" style="height: 700px ">
    <h3 class="mb-2">도서 목록</h3>
    <div style="width:80%" >
      <div class="d-flex justify-content-end">
        <select class="form-select mx-3" style="width: 200px">
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
              <th class="text-center" scope="col">#</th>
              <th class="text-center" scope="col">도서명</th>
              <th class="text-center" scope="col">재고</th>
              <th class="text-center" scope="col">분류</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="text-center">1</td>
              <td class="text-center">하악하악</td>
              <td class="text-center" >4</td>
              <td class="text-center" >기술과학</td>
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