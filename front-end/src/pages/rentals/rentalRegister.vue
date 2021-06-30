<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">도서 대여</h3>
    <form style="width: 300px">
      <div class="my-3">
        <label for="" class="form-label">회원 아이디</label>
        <select id="" class="form-select">
          <option>elswnd</option>
          <option>alswnd</option>
        </select>
      </div>
      <div class="my-3">
        <label for="" class="form-label">도서명</label>
        <select id="" class="form-select">
          <option>하악하악</option>
          <option>vue 3 배우기</option>
        </select>
      </div>
      <br>
      <div class="my-3 text-center">
        <button type="submit" class="btn btn-primary">도서 대여</button>
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