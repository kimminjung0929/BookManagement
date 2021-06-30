<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">도서 등록</h3>
    <form style="width: 500px">
      <div class="my-3">
        <label for="" class="form-label">도서명</label>
        <input type="text" class="form-control" id="" placeholder="도서명을 입력해주세요">
      </div>
      <div class="my-3">
        <label for="inputAddress2" class="form-label">수량</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="수량을 입력해주세요">
      </div>
      <div class="my-3">
        <label for="" class="form-label">도서 분류</label>
        <select id="" class="form-select">
          <option>기술과학</option>
          <option>역사</option>
        </select>
      </div>
      <div class="my-3">
        <label for="inputAddress2" class="form-label">저자</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="저자를 입력해주세요">
      </div>
      <br>
      <div class="my-3 text-center">
        <button type="submit" class="btn btn-primary">도서 등록</button>
      </div>
    </form>
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