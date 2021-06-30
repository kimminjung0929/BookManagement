<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">회원 등록</h3>
    <form>
      <div class="my-3">
        <label for="" class="form-label">회원 아이디</label>
        <input type="text" class="form-control" id="" placeholder="아이디을 입력해주세요">
      </div>
      <div class="my-3">
        <label for="" class="form-label">회원 이름</label>
        <input type="text" class="form-control" id="" placeholder="이름을 입력해주세요">
      </div>
      <div class="my-3">
        <label for="" class="form-label">휴대폰 번호</label>
        <input type="text" class="form-control" id="" placeholder="휴대폰 번호를 입력해주세요">
      </div>
      <br>
      <button type="submit" class="btn btn-primary">회원 등록</button>
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